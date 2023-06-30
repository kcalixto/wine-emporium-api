package com.wineemporium.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    @JsonIgnore
    private Integer id;

    @Column(nullable = false, length = 36)
    @JsonProperty("id")
    private String uuid;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column
    @JsonIgnore
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
    private String ipAddress;

    @OneToMany(mappedBy = "user")
    private Set<UserAddress> userAddress;

    @OneToMany(mappedBy = "user")
    private Set<Purchase> userPurchases;

    @OneToMany(mappedBy = "user")
    private Set<Review> userReviews;

    @PrePersist
    public void prePersist() {
        this.uuid = java.util.UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.active = true;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final LocalDateTime updatedAt) {
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(final String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Set<UserAddress> getUserUserAddress() {
        return userAddress;
    }

    public void setUserUserAddress(final Set<UserAddress> userAddress) {
        this.userAddress = userAddress;
    }

    public Set<Purchase> getUserPurchases() {
        return userPurchases;
    }

    public void setUserPurchases(final Set<Purchase> userPurchases) {
        this.userPurchases = userPurchases;
    }

    public Set<Review> getUserReviews() {
        return userReviews;
    }

    public void setUserReviews(final Set<Review> userReviews) {
        this.userReviews = userReviews;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", active=" + active +
                ", deviceId='" + deviceId + '\'' +
                ", name='" + name + '\'' +
                ", document=" + document +
                ", email='" + email + '\'' +
                ", phoneDomain=" + phoneDomain +
                ", phoneNumber=" + phoneNumber +
                ", ipAddress='" + ipAddress + '\'' +
                ", userAddress=" + userAddress +
                ", userPurchases=" + userPurchases +
                ", userReviews=" + userReviews +
                '}';
    }
}
