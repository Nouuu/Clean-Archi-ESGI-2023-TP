package org.esgi.cleanarchi.infra.cli;


import org.esgi.cleanarchi.infra.cli.dto.StateDto;
import org.esgi.cleanarchi.infra.cli.dto.UpdateDto;
import org.esgi.cleanarchi.infra.cli.dto.parser.UpdateDtoParser;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpdateDtoParseTest {

    @Test
    void parseEntryStringToUpdateDtoWhenStringIsEmpty() {
        UpdateDtoParser updateDtoParser = new UpdateDtoParser();
        UpdateDto result = updateDtoParser.parse(List.of());
        assertEquals(result, new UpdateDto(null, null, null, null));
    }

    @Test
    void parseEntryStringToUpdateDtoWhenDArgIsPresentWithNotValid() {
        UpdateDtoParser updateDtoParser = new UpdateDtoParser();
        UpdateDto result = updateDtoParser.parse(List.of("123", "-d:pomme"));
        assertEquals(result, new UpdateDto(123, null, null, null));

    }

    @Test
    void parseEntryStringToUpdateDtoWhenDArgIsPresentWithAValidValue() {
        UpdateDtoParser updateDtoParser = new UpdateDtoParser();
        UpdateDto result = updateDtoParser.parse(List.of("123", "-d:2020-12-12"));
        assertEquals(result, new UpdateDto(123, null, LocalDate.parse("2020-12-12", DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay(ZoneId.systemDefault()), null));
    }

    @Test
    void parseEntryStringToUpdateDtoWhenDArgIsPresentWithAValidValueANDSHasNotAValidValue() {
        UpdateDtoParser updateDtoParser = new UpdateDtoParser();
        UpdateDto result = updateDtoParser.parse(List.of("123", "-d:2020-12-12", "-s:pomme"));
        assertEquals(result, new UpdateDto(123, null, LocalDate.parse("2020-12-12", DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay(ZoneId.systemDefault()), null));
    }


    @Test
    void parseEntryStringToUpdateDtoWhenDArgIsPresentWithAValidValueANDSAValidValue() {
        UpdateDtoParser updateDtoParser = new UpdateDtoParser();
        UpdateDto result = updateDtoParser.parse(List.of("123", "-d:2020-12-12", "-s:done"));
        assertEquals(result, new UpdateDto(123, null, LocalDate.parse("2020-12-12", DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay(ZoneId.systemDefault()), StateDto.DONE));
    }
}
