package com.example.liquibasebug;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Entity
@Table(name = "pages")
@Getter
@Setter
public class PageModel {

    @Id
    private long id;
    private String title;
}
