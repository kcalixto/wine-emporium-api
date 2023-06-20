package com.wineemporium.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class Winery {

    @Id
    @Column(nullable = false, updatable = false, length = 36)
    private String uuid;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false)
    private OffsetDateTime updatedAt;

    @Column
    private Boolean active;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @Column(nullable = false)
    private Integer country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_id")
    private Wine id;

    @OneToMany(mappedBy = "id")
    private Set<Country> idCountrys;

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

    public Integer getCountry() {
        return country;
    }

    public void setCountry(final Integer country) {
        this.country = country;
    }

    public Wine getId() {
        return id;
    }

    public void setId(final Wine id) {
        this.id = id;
    }

    public Set<Country> getIdCountrys() {
        return idCountrys;
    }

    public void setIdCountrys(final Set<Country> idCountrys) {
        this.idCountrys = idCountrys;
    }

}
