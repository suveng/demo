package com.my.qs.esdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequest;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EsService {

	private static final String INDEX_NAME = "school";

	@Autowired
	private RestHighLevelClient esHttpClient;

	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * 新建一个文档
	 */
	public String index(String name){
		StudentTemplate studentTemplate = new StudentTemplate();
		studentTemplate.setName(name);
		studentTemplate.setAge(10);
		studentTemplate.setBirth(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		List<String> hobby = new ArrayList<>();
		hobby.add("basketball");
		studentTemplate.setHobby(hobby);
		updateSuggest(studentTemplate);

		try {
			IndexRequest indexRequest = new IndexRequest().index(INDEX_NAME)
				.source(objectMapper.writeValueAsBytes(studentTemplate), XContentType.JSON);
			IndexResponse indexResponse = esHttpClient.index(indexRequest, RequestOptions.DEFAULT);
			if (indexResponse.status() == RestStatus.CREATED){
				return "create index success";
			}else{
				return "create index fail";
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "create index fail";
		}

	}

	/**
	 * 更新文档
	 */
	public String update(String name, String updateName){

		try {
			SearchRequest searchRequest = new SearchRequest().indices(INDEX_NAME);
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(QueryBuilders.termQuery("name", name));
			SearchResponse searchResponse = esHttpClient.search(searchRequest, RequestOptions.DEFAULT);
			SearchHit[] hits = searchResponse.getHits().getHits();
			if (hits.length == 0){
				return "not found";
			}
			String source = hits[0].getSourceAsString();
			StudentTemplate studentTemplate = objectMapper.readValue(source, StudentTemplate.class);
			studentTemplate.setName(updateName);

			UpdateRequest updateRequest = new UpdateRequest().index(INDEX_NAME).id(hits[0].getId())
				.doc(objectMapper.writeValueAsBytes(studentTemplate), XContentType.JSON);
			UpdateResponse updateResponse = esHttpClient.update(updateRequest, RequestOptions.DEFAULT);
			if(updateResponse.status() == RestStatus.OK){
				return "update success";
			}else{
				return "update fail";
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "update fail";
		}

	}

	/**
	 * 搜索文档
	 */
	public String search(String name){
		SearchRequest searchRequest = new SearchRequest().indices(INDEX_NAME);
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.termQuery("name", name));
		searchRequest.source(searchSourceBuilder);
		try {
			SearchResponse searchResponse = esHttpClient.search(searchRequest, RequestOptions.DEFAULT);

			String id = searchResponse.getHits().getHits()[0].getId();
			return id;
		} catch (IOException e) {
			e.printStackTrace();
			return "search fail";
		}
	}


	/**
	 * 删除文档
	 */
	public String delete(String name){
		String id = search(name);
		DeleteRequest deleteRequest = new DeleteRequest().index(INDEX_NAME).id(id);
		try {
			DeleteResponse deleteResponse = esHttpClient.delete(deleteRequest, RequestOptions.DEFAULT);
			if (deleteResponse.status() == RestStatus.OK){
				return "delete success";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "delete fail";
	}

	public void updateSuggest(StudentTemplate studentTemplate){
		AnalyzeRequest analyzeRequest = new AnalyzeRequest().index(INDEX_NAME)
			.text(studentTemplate.getName()).analyzer("ik_smart");
		List<com.my.qs.esdemo.service.Suggest> suggestList = new ArrayList<>();
		try {
			AnalyzeResponse analyzeResponse = esHttpClient.indices().analyze(analyzeRequest, RequestOptions.DEFAULT);
			for (AnalyzeResponse.AnalyzeToken token : analyzeResponse.getTokens()) {
				com.my.qs.esdemo.service.Suggest suggest = new com.my.qs.esdemo.service.Suggest();
				suggest.setInput(token.getTerm());
				suggestList.add(suggest);
			}
			studentTemplate.setSuggests(suggestList);
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
		studentTemplate.setSuggests(suggestList);
	}

	/**
	 * 分析分词
	 */
	public String analyze(String text){
		AnalyzeRequest analyzeRequest = new AnalyzeRequest()
			.text(text).analyzer("ik_smart");

		try {
			AnalyzeResponse analyzeResponse = esHttpClient.indices().analyze(analyzeRequest, RequestOptions.DEFAULT);

			List<AnalyzeResponse.AnalyzeToken> tokens = analyzeResponse.getTokens();
			return analyzeResponse.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "fail";
	}

	/**
	 * 模拟自动补全
	 */
	public List<String> autoCompletion(String prefix){
		SearchRequest searchRequest = new SearchRequest().indices(INDEX_NAME);
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.suggest(new SuggestBuilder().addSuggestion("autocomplete",
			SuggestBuilders.completionSuggestion("suggests").size(5).prefix(prefix)));
		searchRequest.source(searchSourceBuilder);
		List<String> resultList = new ArrayList<>();
		try {
			SearchResponse searchResponse = esHttpClient.search(searchRequest, RequestOptions.DEFAULT);
			Suggest.Suggestion autocomplete = searchResponse.getSuggest().getSuggestion("autocomplete");

			for (Object o : autocomplete) {
				if (o instanceof CompletionSuggestion.Entry){
					CompletionSuggestion.Entry entry = (CompletionSuggestion.Entry) o;
					for (CompletionSuggestion.Entry.Option option : entry) {
						resultList.add(option.getText().toString());
					}
				}
			}
			return resultList;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultList;
	}
}
