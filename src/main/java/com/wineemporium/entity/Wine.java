package com.wineemporium.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wineemporium.entity.enums.TasteEnum;

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

    @Column(nullable = false)
    private OffsetDateTime updatedAt;

    @Column
    @JsonIgnore
    private Boolean active;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TasteEnum taste;

    @Column(nullable = false)
    private Integer age;

    @OneToMany(mappedBy = "wine")
    private Set<ItemPurchase> wineItemPurchases;

    @OneToMany(mappedBy = "wine")
    private Set<Ratings> wineRatingss;

    @OneToMany(mappedBy = "wine")
    private Set<Review> wineReviews;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winery_id", nullable = false)
    private Winery winery;

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

    public Winery getWinery() {
        return winery;
    }

    public void setWinery(final Winery winery) {
        this.winery = winery;
    }

    public TasteEnum getTaste() {
        return taste;
    }

    public void setTaste(final TasteEnum taste) {
        this.taste = taste;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public Set<ItemPurchase> getWineItemPurchases() {
        return wineItemPurchases;
    }

    public void setWineItemPurchases(final Set<ItemPurchase> wineItemPurchases) {
        this.wineItemPurchases = wineItemPurchases;
    }

    public Set<Ratings> getWineRatingss() {
        return wineRatingss;
    }

    public void setWineRatingss(final Set<Ratings> wineRatingss) {
        this.wineRatingss = wineRatingss;
    }

    public Set<Review> getWineReviews() {
        return wineReviews;
    }

    public void setWineReviews(final Set<Review> wineReviews) {
        this.wineReviews = wineReviews;
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
                ", age=" + age +
                ", wineItemPurchases=" + wineItemPurchases +
                ", wineRatingss=" + wineRatingss +
                ", wineReviews=" + wineReviews +
                ", winery=" + winery +
                '}';
    }
}
