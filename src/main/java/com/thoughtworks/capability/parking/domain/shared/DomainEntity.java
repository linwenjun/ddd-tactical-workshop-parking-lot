package com.thoughtworks.capability.parking.domain.shared;

public interface DomainEntity<T> {

    boolean sameIdentityAs(T other);
}
