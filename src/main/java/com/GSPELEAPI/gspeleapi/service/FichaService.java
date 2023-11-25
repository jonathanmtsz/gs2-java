package com.GSPELEAPI.gspeleapi.service;

import com.GSPELEAPI.gspeleapi.beans.Ficha;
import com.GSPELEAPI.gspeleapi.beans.Historico;

import java.util.List;
import java.util.Optional;

public interface FichaService {
    Ficha createFicha (Ficha ficha);
    String updateFicha (Ficha ficha);
    String deleteFicha (Integer id_ficha);
    Optional<Ficha> getFicha (Integer id_ficha);
    List<Ficha> getAllFicha ();
}
