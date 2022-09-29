# encoding:utf-8

class Parcela

    @nombre = nombre
    @precioCompra = precioCompra
    @precioEdificar = precioEdificar
    @precioBaseAlquiler = precioBaseAlquiler
    @numCasas = 0
    @numHoteles = 0
    
    def self.construir_casa
        @numCasas += 1
    end

    def self.construir_hotel
        @numHoteles += 1
    end

    def self.getPrecioAlquilerCompleto
        puts @precioBaseAlquiler * (1 + @numCasas*1 + @numHoteles*4)
    end
end

parcela = Parcela.new
parcela.construir_casa()
parcela.construir_hotel()
parcela.getPrecioAlquilerCompleto()