package org.esgi.cleanarchi.cli;


import org.esgi.cleanarchi.infra.cli.dto.StateDto;
import org.esgi.cleanarchi.infra.cli.dto.UpdateDto;
import org.esgi.cleanarchi.infra.cli.dto.parser.UpdateDtoParser;
import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UpdateDtoParseTest {

    @Test
    public void ParseEntryStringToUpdateDtoWhenStringIsEmpty()
    {
        UpdateDtoParser updateDtoParser = new UpdateDtoParser();
        UpdateDto result = updateDtoParser.parse(List.of());
        assert result.equals(new UpdateDto(null, null, null, null));
    }

    @Test
    public void ParseEntryStringToUpdateDtoWhenDArgIsPresentWithNotValid()
    {
        UpdateDtoParser updateDtoParser = new UpdateDtoParser();
        UpdateDto result = updateDtoParser.parse(List.of("123", "-d:pomme"));
        assert result.equals(new UpdateDto(123, null, null, null));
    }

    @Test
    public void ParseEntryStringToUpdateDtoWhenDArgIsPresentWithAValidValue()
    {
        UpdateDtoParser updateDtoParser = new UpdateDtoParser();
        UpdateDto result = updateDtoParser.parse(List.of("123", "-d:2020-12-12"));
        assert result.equals(new UpdateDto(123, null, LocalDate.parse("2020-12-12",  DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay(ZoneId.systemDefault()), null));
    }

    @Test
    public void ParseEntryStringToUpdateDtoWhenDArgIsPresentWithAValidValueANDSHasNotAValidValue()
    {
        UpdateDtoParser updateDtoParser = new UpdateDtoParser();
        UpdateDto result = updateDtoParser.parse(List.of("123", "-d:2020-12-12", "-s:pomme"));
        assert result.equals(new UpdateDto(123, null, LocalDate.parse("2020-12-12",  DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay(ZoneId.systemDefault()), null));
    }


    @Test
    public void ParseEntryStringToUpdateDtoWhenDArgIsPresentWithAValidValueANDSAValidValue()
    {
        UpdateDtoParser updateDtoParser = new UpdateDtoParser();
        UpdateDto result = updateDtoParser.parse(List.of("123", "-d:2020-12-12", "-s:done"));
        assert result.equals(new UpdateDto(123, null, LocalDate.parse("2020-12-12",  DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay(ZoneId.systemDefault()), StateDto.DONE));
    }
}
