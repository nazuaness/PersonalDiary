package com.diary.web.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "note")
@Getter
@Setter
@NoArgsConstructor
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String noteName;
    private String noteDes;

    public Notes(final String noteName, final String noteDes) {
       this.noteName = noteName;
       this.noteDes = noteDes;
    }

}