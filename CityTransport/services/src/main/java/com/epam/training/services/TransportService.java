package com.epam.training.services;

import com.epam.training.dataaccess.model.Transport;

public interface TransportService {

	void insertOrUpdate(Transport transport);

	Transport get(Long id);
}
