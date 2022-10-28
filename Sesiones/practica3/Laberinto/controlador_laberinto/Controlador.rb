require_relative '../modelo_laberinto/laberinto.rb'
require_relative '../modelo_laberinto/habitacion.rb'
require_relative '../modelo_laberinto/elemento_separador.rb'
require_relative '../modelo_laberinto/direccion.rb'
require_relative 'Estado_juego'

module Controlador_laberinto

    class Controlador

        attr_reader :vidas, :habitacion, :estado
        
        def initialize (modelo)
            @vidas = 0
            @laberinto = modelo
            @habitacion=nil
            @estado = Estado_juego::EN_ENTRADA_LABERINTO   
        end
        
        def entrar(vidas)
            @habitacion = @laberinto.puerta_entrada.habitacion_al_otro_lado(@habitacion)
            #No seria más cómodo? --> @habitacion = @laberinto.habitacion[0]
            pared = Elemento_separador.nueva_pared(nil, @habitacion) #Laberinto.habitaciones[0]
            @laberinto.habitaciones[0].set_lado(Direccion::SUR, pared)
            @vidas = vidas
            if @vidas > 0
                @estado = Estado_juego::DENTRO_VIVO
            else
                @estado= Estado_juego::DENTRO_MUERTO
            end
        end
        
        def intentar_avanzar()
            direccion = Lista_direcciones[rand(4)]
            if @habitacion.pasar(direccion)
                @habitacion = @habitacion.get_lado(direccion).habitacion_al_otro_lado(@habitacion)
            else
                vidas -= 1
            end
            if @habitacion == nil
                @estado = Estado_juego::EN_SALIDA_LABERINTO
            else
                if vidas <= 0
                    @estado = Estado_juego::DENTRO_MUERTO
                else
                    @estado =Estado_juego::DENTRO_VIVO
                end
            end
            return direccion
        end        
    end
end