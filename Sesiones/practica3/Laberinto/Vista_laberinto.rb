# encoding:utf-8

require_relative 'controlador_laberinto/Controlador.rb'
require_relative 'controlador_laberinto/Estado_juego.rb'

class Vista_laberinto
    def initialize(controlador)
        @controlador = controlador
    end

    def menu_usuario
        actual = @controlador.estado
        if actual == Estado_juego::EN_ENTRADA_LABERINTO
            numero = -1
            while numero < 1 || numero > 10
                numero = gets.chomp().to_i
            end
            @controlador.vidas = numero
        end

        if actual == Estado_juego::DENTRO_VIVO
            informe_dentro(@controlador.habitacion, ,@controlador.vidas)
            puts 'press the enter key'
            names = gets
            while names != '\n'
            end
            puts @controlador.intentar_avanzar
        end

        if actual == Estado_juego::EN_SALIDA_LABERINTO || Estado_juego::DENTRO_MUERTO
            informe_final(@controlador.vidas)
            exit()
        end
    end

    def informe_dentro(habitacion, vidas)
        puts "Lugar: " + habitacion
        puts "Vidas: " + vidas
    end

    def informe_final(vidas)
        puts "Vidas: " + vidas
    end
end