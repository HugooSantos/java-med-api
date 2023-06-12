package fat.pe.api.domain.doctors;

import fat.pe.api.domain.address.AddressData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataStoreDoctors(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String crm,
        @NotBlank
        String phone,
        @NotNull
        Speciality speciality,
        @NotNull
        @Valid
        AddressData addressData) {
}
