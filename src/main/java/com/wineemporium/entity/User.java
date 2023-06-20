package com.wineemporium.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer id;

    @Column(nullable = false, length = 36)
    private String uuid;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false)
    private OffsetDateTime updatedAt;

    @Column
    private Boolean active;

    @Column(nullable = false, length = 36)
    private String deviceId;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false)
    private Integer document;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer phoneDomain;

    @Column(nullable = false)
    private Integer phoneNumber;

    @Column(nullable = false)
    private Integer ipAddress;

    @OneToMany(mappedBy = "user")
    private Set<UserAddress> userUserAddress;

    @OneToMany(mappedBy = "user")
    private Set<Purchase> userPurchases;

    @OneToMany(mappedBy = "owner")
    private Set<Review> ownerReviews;

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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(final String deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getDocument() {
        return document;
    }

    public void setDocument(final Integer document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Integer getPhoneDomain() {
        return phoneDomain;
    }

    public void setPhoneDomain(final Integer phoneDomain) {
        this.phoneDomain = phoneDomain;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(final Integer ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Set<UserAddress> getUserUserAddress() {
        return userUserAddress;
    }

    public void setUserUserAddress(final Set<UserAddress> userUserAddress) {
        this.userUserAddress = userUserAddress;
    }

    public Set<Purchase> getUserPurchases() {
        return userPurchases;
    }

    public void setUserPurchases(final Set<Purchase> userPurchases) {
        this.userPurchases = userPurchases;
    }

    public Set<Review> getOwnerReviews() {
        return ownerReviews;
    }

    public void setOwnerReviews(final Set<Review> ownerReviews) {
        this.ownerReviews = ownerReviews;
    }

}
