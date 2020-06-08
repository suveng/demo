package com.my.qs.esdemo.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class elasticConfig {

	@Value("${es.host}")
	private String host;

	@Value("${es.http.port}")
	private String port;

	@Bean
	public RestHighLevelClient esHttpClient(){
		return new RestHighLevelClient(RestClient.builder(new HttpHost(host, Integer.parseInt(port), "http")));
	}
}
