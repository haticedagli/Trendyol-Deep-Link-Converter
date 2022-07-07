package com.trendyol.deeplinkconverter.entity;

import com.trendyol.deeplinkconverter.constant.Page;
import com.trendyol.deeplinkconverter.constant.Scope;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "link")
@Getter
@Setter
public class LinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "scope")
    @Enumerated(EnumType.STRING)
    private Scope scope;

    @Column(name = "page")
    @Enumerated(EnumType.STRING)
    private Page page;

    @Column(name = "deeplink")
    private String deeplink;

    @Column(name = "url")
    private String url;

    @Column(name = "create_date")
    private LocalDateTime date;
}
