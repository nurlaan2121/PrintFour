package org.example.printfour.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.printfour.repository.PhotoRepo;
import org.example.printfour.repository.UserRepo;
import org.example.printfour.service.PhotoService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotoImpl implements PhotoService {
    private final PhotoRepo photoRepo;
    private final UserRepo userRepo;
}
