package com.example.github.projects.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;
    @Column(name="title", nullable = false)
    @JsonProperty("taskTitle")
    private String taskTitle;
    @Column(name = "description", nullable = true)
    private String taskDescription;
    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private Priority taskPriority;//(low, medium, high)
    @Column(name = "stage")
    @Enumerated(EnumType.STRING)
    private Stage taskStage;// (to-do, inprogress, done
    @Column(name="created_on", updatable = false)
    @CreationTimestamp
    private LocalDateTime taskCreatedOn;
    @UpdateTimestamp
    @Column(name = "updated_on")
    private LocalDateTime taskUpdatedOn;
}
