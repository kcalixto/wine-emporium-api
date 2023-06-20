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
public class Country {

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

    @OneToMany(mappedBy = "country")
    private Set<Address> countryAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_id")
    private Winery id;

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

    public Set<Address> getCountryAddress() {
        return countryAddress;
    }

    public void setCountryAddress(final Set<Address> countryAddress) {
        this.countryAddress = countryAddress;
    }

    public Winery getId() {
        return id;
    }

    public void setId(final Winery id) {
        this.id = id;
    }

}
