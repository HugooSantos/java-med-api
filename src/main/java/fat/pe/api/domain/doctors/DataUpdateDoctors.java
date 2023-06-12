package fat.pe.api.domain.doctors;

import fat.pe.api.domain.address.AddressData;
import jakarta.validation.constraints.NotNull;

public record DataUpdateDoctors(
        @NotNull
        Long id,
        String name,

        String phone,
        AddressData addressData) {
}
