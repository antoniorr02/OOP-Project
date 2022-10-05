# encoding:utf-8

class Parcela

    @@FACTORALQUILERCALLE = 1.0
    @@FACTORALQUILERCASA  = 1.0
    @@FACTORALQUILERHOTEL = 4.0

    def initialize(nombre, precioCompra, precioEdificar, precioBaseAlquiler)
        @nombre = nombre
        @precioCompra = precioCompra
        @precioEdificar = precioEdificar
        @precioBaseAlquiler = precioBaseAlquiler
        @numCasas = 0
        @numHoteles = 0
    end

    def nombre
        @nombre
    end

    def precioCompra
        @precioCompra
    end

    def precioEdificar
        @precioEdificar
    end

    def precioBaseAlquiler
        @precioBaseAlquiler
    end

    def numCasas
        @numCasas
    end

    def numHoteles
        @numHoteles
    end

    def construir_casa
        @numCasas += 1
    end

    def construir_hotel
        @numHoteles += 1
    end

    def getPrecioAlquilerCompleto
        puts @precioBaseAlquiler * (@@FACTORALQUILERCALLE + @numCasas*@@FACTORALQUILERCASA + @numHoteles*@@FACTORALQUILERHOTEL)
    end
end

parcela = Parcela.new("nombre", 10, 20,5)
parcela.construir_casa()
parcela.construir_hotel()
parcela.getPrecioAlquilerCompleto()