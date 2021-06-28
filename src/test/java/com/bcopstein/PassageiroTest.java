package com.bcopstein;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.bcopstein.entidades.Bairro;
import com.bcopstein.entidades.Passageiro;
import com.bcopstein.entidades.Roteiro;
import com.bcopstein.entidades.geometria.Area;
import com.bcopstein.entidades.geometria.Ponto;
import com.bcopstein.entidades.geometria.Reta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PassageiroTest {
    private Passageiro passageiro;

    @BeforeEach
    public void setup(){
        passageiro = Passageiro.passageiroExistente("000.000.000-99", "teste", 8, 2);
    }

    @Test
    public void testaNovoPassageiro(){
        Passageiro pass = Passageiro.novoPassageiro("000.000.000-99", "teste");
        Passageiro passageiroEsperado = Passageiro.passageiroExistente("000.000.000-99", "teste", 8, 1);
        assertEquals(pass, passageiroEsperado);
    }

    @Test
    public void testaPassageiroExistente(){
        Passageiro pass = Passageiro.passageiroExistente("000.000.000-99", "teste",7,4);
        Passageiro passageiroEsperado = Passageiro.passageiroExistente("000.000.000-99", "teste", 7,4);
        assertEquals(pass, passageiroEsperado);
    }

    @Test
    public void testaGetPontuacaoMedia(){
        assertEquals(passageiro.getPontuacaoMedia(), 4);
    }

    @Test
    public void testaInfoPontuacao(){
        passageiro.infoPontuacao(1);
        Passageiro passageiroEsperado = Passageiro.passageiroExistente("000.000.000-99", "teste", 9,3);
        assertEquals(passageiro, passageiroEsperado);
    }

    @Test
    public void testaInfoPontuacaoInvalida(){  
        try {
            passageiro.infoPontuacao(-1);
        } catch (Exception e) {
            assertEquals("Pontucao invalida !", e.getMessage());
        }
    }
}
