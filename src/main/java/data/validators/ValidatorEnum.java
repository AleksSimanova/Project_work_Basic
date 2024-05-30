package data.validators;

public class ValidatorEnum {
    public <T extends Enum<T>> boolean checkValuesInEnam(Class<T> enumType, String value) {
        for (T val : enumType.getEnumConstants()) {
            if (val.name().equals(value)) {
                return true;
            }
        }

        return false;
    }
}
