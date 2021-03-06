package com.github.homework.program.domain;


import com.github.homework.theme.domain.Theme;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
    name = "program_seq_generator",
    sequenceName = "program_seq", allocationSize = 10)
@EqualsAndHashCode(of = "id")
@ToString
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "program_seq_generator")
    private Long id;
    private String name;
    private String introduction;
    private String region;
    @Lob
    private String introductionDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @Builder
    public Program(String name, String introduction, String introductionDetail, String region, Theme theme) {
        this.name = name;
        this.introduction = introduction;
        this.introductionDetail = introductionDetail;
        this.region = region;
        this.theme = theme;
    }

    public void updateProgram(String name, String introduction, String introductionDetail, String region, Theme theme) {
        this.name = name;
        this.introduction = introduction;
        this.introductionDetail = introductionDetail;
        this.region = region;
        this.theme = theme;
    }
}
