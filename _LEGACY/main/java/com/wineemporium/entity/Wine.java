package com.wineemporium.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wineemporium.utils.Validate;

@Entity
public class Wine {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    @JsonIgnore
    private Integer id;

    @Column(nullable = false, length = 36)
    @JsonProperty("id")
    private String uuid;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    public Wine() {
    }

    public Wine(String name, String description, BigDecimal price, String taste, Integer age_in_years,
            List<Winery> winery) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.taste = taste;
        this.age_in_years = age_in_years;
        this.winery = winery;
    }

    public Wine(Integer id, String uuid, OffsetDateTime createdAt, OffsetDateTime updatedAt, Boolean active,
            String name, String description, BigDecimal price, String taste, Integer age_in_years,
            List<Winery> winery) {
        this.id = id;
        this.uuid = uuid;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
        this.name = name;
        this.description = description;
        this.price = price;
        this.taste = taste;
        this.age_in_years = age_in_years;
        this.winery = winery;
    }

    @Column(nullable = false)
    private OffsetDateTime updatedAt;

    @Column
    @JsonIgnore
    private Boolean active;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private String taste;

    @Column(nullable = false)
    private Integer age_in_years;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "wine_winery", joinColumns = @JoinColumn(name = "wine_id"), inverseJoinColumns = @JoinColumn(name = "winery_id"))
    private List<Winery> winery;

    @PrePersist
    public void prePersist() {
        this.uuid = java.util.UUID.randomUUID().toString();
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
        this.active = true;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = OffsetDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public List<Winery> getWinery() {
        return winery;
    }

    public void setWinery(final List<Winery> winery) {
        this.winery = winery;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(final String taste) {
        this.taste = taste;
    }

    public Integer getAge() {
        return age_in_years;
    }

    public void setAge(final Integer age_in_years) {
        this.age_in_years = age_in_years;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", active=" + active +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", taste=" + taste +
                ", age_in_years=" + age_in_years +
                ", winery=" + winery +
                '}';
    }

    public Validate validate() {
        Validate v = new Validate();

        if (this.name == null || this.name.isEmpty()) {
            v.add("name", "Name must not be empty");
        }
        if (this.price == null || this.price.equals(0)) {
            v.add("price", "Price must be greater than 0");
        }
        if (this.taste == null || this.taste.isEmpty()) {
            v.add("taste", "Taste must not be empty");
        }
        if (this.age_in_years == null) {
            v.add("age", "Age must not be empty");
        }
        if (this.winery == null || this.winery.size() == 0) {
            v.add("winery", "Winery must not be empty");
        }

        return v;
    }
}
