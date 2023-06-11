package fat.pe.api.address;

import jakarta.validation.constraints.NotBlank;

public record AddressData(
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank
        String cep,
        @NotBlank
        String city,
        @NotBlank
        String state,
        String complement,
        String number) {
}
