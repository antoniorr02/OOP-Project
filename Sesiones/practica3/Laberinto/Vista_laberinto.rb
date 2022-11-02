# encoding:utf-8

require_relative 'controlador_laberinto/Controlador.rb'
require_relative 'controlador_laberinto/Estado_juego.rb'

class Vista_laberinto
    def initialize(controlador)
        @controlador = controlador
    end

    def informe_dentro(habitacion, vidas)
        puts "Habitación actual: #{habitacion}  Vidas: #{vidas}"
    end

    def informe_final(vidas)
        puts "Vidas: #{vidas}"
    end

    def menu_usuario
        if @controlador.estado == Controlador_laberinto::Estado_juego::EN_ENTRADA_LABERINTO
            numero = -1
            while numero < 1 || numero > 10
                numero = gets.chomp().to_i
            end
            @controlador.entrar(numero)
        end

        if @controlador.estado == Controlador_laberinto::Estado_juego::DENTRO_VIVO
            informe_dentro(@controlador.habitacion.num_habitacion, @controlador.vidas)
            puts 'press a key'
            names = gets.chomp()
            puts @controlador.intentar_avanzar
            menu_usuario()
        end

        if @controlador.estado == Controlador_laberinto::Estado_juego::EN_SALIDA_LABERINTO || Controlador_laberinto::Estado_juego::DENTRO_MUERTO
            informe_final(@controlador.vidas)
            exit()
        end
    end
end