package com.my.qs.esdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
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



}
