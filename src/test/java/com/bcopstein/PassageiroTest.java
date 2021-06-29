package com.bcopstein;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.bcopstein.entidades.Passageiro;

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
        assertEquals(pass.getCPF(), passageiroEsperado.getCPF());
        assertEquals(pass.getNome(), passageiroEsperado.getNome());
        assertEquals(pass.getPontuacaoAcumulada(), passageiroEsperado.getPontuacaoAcumulada());
        assertEquals(pass.getQtdadeAvaliacoes(), passageiroEsperado.getQtdadeAvaliacoes());
    }

    @Test
    public void testaPassageiroExistente(){
        Passageiro pass = Passageiro.passageiroExistente("000.000.000-99", "teste",7,4);
        Passageiro passageiroEsperado = Passageiro.passageiroExistente("000.000.000-99", "teste", 7,4);
        assertEquals(pass.getCPF(), passageiroEsperado.getCPF());
        assertEquals(pass.getNome(), passageiroEsperado.getNome());
        assertEquals(pass.getPontuacaoAcumulada(), passageiroEsperado.getPontuacaoAcumulada());
        assertEquals(pass.getQtdadeAvaliacoes(), passageiroEsperado.getQtdadeAvaliacoes());
    }

    @Test
    public void testaGetPontuacaoMedia(){
        assertEquals(passageiro.getPontuacaoMedia(), 4);
    }

    @Test
    public void testaInfoPontuacao(){
        passageiro.infoPontuacao(1);
        Passageiro passageiroEsperado = Passageiro.passageiroExistente("000.000.000-99", "teste", 9,3);
        assertEquals(passageiro.getCPF(), passageiroEsperado.getCPF());
        assertEquals(passageiro.getNome(), passageiroEsperado.getNome());
        assertEquals(passageiro.getPontuacaoAcumulada(), passageiroEsperado.getPontuacaoAcumulada());
        assertEquals(passageiro.getQtdadeAvaliacoes(), passageiroEsperado.getQtdadeAvaliacoes());
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
