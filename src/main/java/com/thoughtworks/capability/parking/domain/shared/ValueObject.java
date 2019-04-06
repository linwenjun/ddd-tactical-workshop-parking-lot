package com.thoughtworks.capability.parking.domain.shared;

public interface ValueObject<T> {

    boolean sameValueAs(T other);
}
