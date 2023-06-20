package com.wineemporium.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class Purchase {

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

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @OneToMany(mappedBy = "purchase")
    private Set<PurchaseStatus> purchasePurchaseStatuss;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_address_id", nullable = false)
    private UserAddress userAddress;

    @OneToMany(mappedBy = "purchase")
    private Set<ItemPurchase> purchaseItemPurchases;

    @OneToMany(mappedBy = "purchase")
    private Set<Uber> purchaseUbers;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    public Set<PurchaseStatus> getPurchasePurchaseStatuss() {
        return purchasePurchaseStatuss;
    }

    public void setPurchasePurchaseStatuss(final Set<PurchaseStatus> purchasePurchaseStatuss) {
        this.purchasePurchaseStatuss = purchasePurchaseStatuss;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(final UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public Set<ItemPurchase> getPurchaseItemPurchases() {
        return purchaseItemPurchases;
    }

    public void setPurchaseItemPurchases(final Set<ItemPurchase> purchaseItemPurchases) {
        this.purchaseItemPurchases = purchaseItemPurchases;
    }

    public Set<Uber> getPurchaseUbers() {
        return purchaseUbers;
    }

    public void setPurchaseUbers(final Set<Uber> purchaseUbers) {
        this.purchaseUbers = purchaseUbers;
    }

}
