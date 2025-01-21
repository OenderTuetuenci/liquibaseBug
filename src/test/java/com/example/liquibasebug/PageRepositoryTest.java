package com.example.liquibasebug;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@Tag("database")
class PageRepositoryTest {

    @Autowired
    private PageRepository pageRepository;

    private PageModel pageModel;

    @BeforeEach
    void setup() {
        pageModel = new PageModel();
        pageModel.setId(1);
        pageModel.setTitle("lala");
        pageRepository.saveAndFlush(pageModel);
    }

    @Test
    @DisplayName("should find a page by id")
    void findOne() {
        Optional<PageModel> foundModel = pageRepository.findById(pageModel.getId());
        assertThat(foundModel).isPresent();
    }

}
