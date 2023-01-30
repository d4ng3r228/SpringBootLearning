package com.spring.springbootlearning.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "title", nullable = false, length = 45)
    private String title;
    @Basic
    @Column(name = "completed_count", nullable = true)
    private Long completedCount;
    @Basic
    @Column(name = "uncompleted_count", nullable = true)
    private Long uncompletedCount;
    @OneToMany(mappedBy = "categoryByCategoryId")
    private Collection<Task> tasksById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(Long completedCount) {
        this.completedCount = completedCount;
    }

    public Long getUncompletedCount() {
        return uncompletedCount;
    }

    public void setUncompletedCount(Long uncompletedCount) {
        this.uncompletedCount = uncompletedCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        if (title != null ? !title.equals(category.title) : category.title != null) return false;
        if (completedCount != null ? !completedCount.equals(category.completedCount) : category.completedCount != null)
            return false;
        if (uncompletedCount != null ? !uncompletedCount.equals(category.uncompletedCount) : category.uncompletedCount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (completedCount != null ? completedCount.hashCode() : 0);
        result = 31 * result + (uncompletedCount != null ? uncompletedCount.hashCode() : 0);
        return result;
    }

    public Collection<Task> getTasksById() {
        return tasksById;
    }

    public void setTasksById(Collection<Task> tasksById) {
        this.tasksById = tasksById;
    }
}
