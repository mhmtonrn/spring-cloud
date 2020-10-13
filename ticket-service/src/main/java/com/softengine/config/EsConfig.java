package com.softengine.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.softengine.repository")
public class EsConfig {

    @Value("${elasticsearch.host}")
    private String elasticsearchHost;

    @Value("${elasticsearch.port}")
    private int elasticsearchPort;

    @Value("${elasticsearch.cluster_name}")
    private String elasticsearchClusterName;

    public Client client() throws Exception {

        Settings esSettings = Settings.builder()
                .put("cluster.name", elasticsearchClusterName)
                .build();

        TransportClient client = new PreBuiltTransportClient(esSettings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(elasticsearchHost), elasticsearchPort));

//        return new PreBuiltTransportClient(esSettings)
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(elasticsearchHost), elasticsearchPort));
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }

}