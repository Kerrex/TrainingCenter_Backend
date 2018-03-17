package pl.kerrex.trainingcenterbackend.config

import org.springframework.orm.jpa.JpaTransactionManager
import javax.persistence.EntityManagerFactory
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import java.beans.PropertyVetoException
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = ["pl.kerrex.trainingcenterbackend.repository"])
open class DatasourceConfig {

    @Bean
    @Throws(PropertyVetoException::class)
    open fun datasource(): DataSource {
        val builder = EmbeddedDatabaseBuilder()

        return builder
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("sql-scripts/schema.sql")
                .addScript("sql-scripts/data.sql")
                .build()
    }

    @Bean
    @Throws(PropertyVetoException::class)
    open fun entityManagerFactory(@Qualifier("datasource") ds: DataSource): LocalContainerEntityManagerFactoryBean {
        val entityManagerFactory = LocalContainerEntityManagerFactoryBean()
        entityManagerFactory.dataSource = ds
        entityManagerFactory.setPackagesToScan("pl.kerrex.trainingcenterbackend.domain")
        val jpaVendorAdapter = HibernateJpaVendorAdapter()
        entityManagerFactory.jpaVendorAdapter = jpaVendorAdapter
        return entityManagerFactory
    }

    @Bean
    open fun transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = entityManagerFactory
        return transactionManager
    }
}