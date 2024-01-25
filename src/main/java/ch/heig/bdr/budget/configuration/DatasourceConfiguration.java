package ch.heig.bdr.budget.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

@Configuration
@MapperScan("ch.heig.bdr.budget.categorie.mapper")
@MapperScan("ch.heig.bdr.budget.depense.mapper")
@MapperScan("ch.heig.bdr.budget.epargne.mapper")
@MapperScan("ch.heig.bdr.budget.recette.mapper")
@MapperScan("ch.heig.bdr.budget.revenu.mapper")
@MapperScan("ch.heig.bdr.budget.recurrence.mapper")
@MapperScan("ch.heig.bdr.budget.epargne.mapper")
@MapperScan("ch.heig.bdr.budget.objEpargne.mapper")
public class DatasourceConfiguration {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(datasource);
        return factoryBean.getObject();
    }
}
