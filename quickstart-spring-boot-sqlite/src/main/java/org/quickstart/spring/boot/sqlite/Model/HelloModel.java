package org.quickstart.spring.boot.sqlite.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HelloModel {
    private long id;
    private String title;
    private String text;
}
