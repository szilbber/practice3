package com.example.restaurant;

import com.example.restaurant.dto.VisitorRequestDTO;
import com.example.restaurant.dto.VisitorResponseDTO;
import com.example.restaurant.mapper.VisitorMapper;
import com.example.restaurant.model.Visitor;
import com.example.restaurant.repository.VisitorRepository;
import com.example.restaurant.service.VisitorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class VisitorServiceTest {

    @Mock
    private VisitorRepository visitorRepository;

    @Mock
    private VisitorMapper visitorMapper;

    @InjectMocks
    private VisitorService visitorService;

    private Visitor visitor;
    private VisitorRequestDTO visitorRequestDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        visitor = new Visitor(1L, "Иван", 30, "мужской");
        visitorRequestDTO = new VisitorRequestDTO("Иван", 30, "мужской");
    }

    @Test
    public void testFindById() {
        when(visitorRepository.findById(1L)).thenReturn(Optional.of(visitor));
        when(visitorMapper.toResponseDTO(visitor)).thenReturn(new VisitorResponseDTO(1L, "Иван", 30, "мужской"));

        VisitorResponseDTO result = visitorService.findById(1L);

        assertNotNull(result);
        assertEquals("Иван", result.getName());
        verify(visitorRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindAll() {
        when(visitorRepository.findAll()).thenReturn(List.of(visitor));
        when(visitorMapper.toResponseDTO(visitor)).thenReturn(new VisitorResponseDTO(1L, "Иван", 30, "мужской"));

        List<VisitorResponseDTO> result = visitorService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(visitorRepository, times(1)).findAll();
    }

    @Test
    public void testSave() {
        when(visitorMapper.toEntity(visitorRequestDTO)).thenReturn(visitor);
        when(visitorRepository.save(visitor)).thenReturn(visitor);
        when(visitorMapper.toResponseDTO(visitor)).thenReturn(new VisitorResponseDTO(1L, "Иван", 30, "мужской"));

        VisitorResponseDTO result = visitorService.save(visitorRequestDTO);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(visitorRepository, times(1)).save(visitor);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(visitorRepository).deleteById(1L);
        visitorService.deleteById(1L);
        verify(visitorRepository, times(1)).deleteById(1L);
    }
}