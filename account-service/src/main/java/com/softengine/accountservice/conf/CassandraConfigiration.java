package com.softengine.accountservice.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfigiration extends AbstractCassandraConfiguration {

    @Value("${spcloud.cassandra.keyspace.name}")
    private String keyspaceName;

    @Value("${spcloud.cassandra.contact.point}")
    private String contactPoint;

    @Value("${spcloud.cassandra.port}")
    private int port;

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    protected int getPort() {
        return this.port;
    }

    @Override
    protected String getContactPoints() {
        return this.contactPoint;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.NONE;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"com.softengine.accountservice"};
    }

    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean clusterFactoryBean = super.cluster();
        clusterFactoryBean.setUsername("cassandra");
        clusterFactoryBean.setPassword("cassandra");
        return  clusterFactoryBean;
    }
}
