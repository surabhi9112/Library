package com.cnb.library.service;

import com.cnb.library.model.Book;
import com.cnb.library.model.Location;

public interface LocationService {

    void updateLocation(long bookId, Location location);

    Location findBookLocation(long id);

}
