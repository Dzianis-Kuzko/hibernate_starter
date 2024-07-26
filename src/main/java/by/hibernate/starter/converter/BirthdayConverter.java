package by.hibernate.starter.converter;

import by.hibernate.starter.entity.Birthday;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.sql.Date;
import java.time.LocalDate;

@Converter(autoApply = true)
public class BirthdayConverter implements AttributeConverter<Birthday, Date> {
    @Override
    public Date convertToDatabaseColumn(Birthday attribute) {
        Date date = null;
        if (attribute != null) {
            date = Date.valueOf(attribute.birthDate());
        }

        return date;
    }

    @Override
    public Birthday convertToEntityAttribute(Date dbData) {
        LocalDate birthDate = null;
        if (dbData != null) {
            birthDate = dbData.toLocalDate();
        }

        return new Birthday(birthDate);
    }
}
