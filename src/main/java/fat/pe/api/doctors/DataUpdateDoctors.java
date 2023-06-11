package fat.pe.api.doctors;

import fat.pe.api.address.AddressData;
import jakarta.validation.constraints.NotNull;

public record DataUpdateDoctors(
        @NotNull
        Long id,
        String name,

        String phone,
        AddressData addressData) {
}
