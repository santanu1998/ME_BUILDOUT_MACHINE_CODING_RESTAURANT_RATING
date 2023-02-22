package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Restaurant;

public class RestaurantRepository implements IRestaurantRepository {

    private final Map<Long, Restaurant> restaurantMap;
    private Long autoIncrement = 1L;

    public RestaurantRepository(){
        restaurantMap = new HashMap<Long, Restaurant>();
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        if (restaurant.getId() == null) {
            Restaurant myRestaurant = new Restaurant(autoIncrement, restaurant.getName());
            restaurantMap.put(myRestaurant.getId(), myRestaurant);
            ++autoIncrement;
            return myRestaurant;
        }
        restaurantMap.put(restaurant.getId(), restaurant);
        return restaurant;
    }

    @Override
    public boolean existsById(Long id) {
        return restaurantMap.containsKey(id);
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return Optional.ofNullable(restaurantMap.get(id));
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        restaurantMap.remove(id);
    }

    @Override
    public long count() {
        return restaurantMap.size();
    }

    @Override
    public void delete(Restaurant restaurant) {
        restaurantMap.remove(restaurant);
    }
    
}
