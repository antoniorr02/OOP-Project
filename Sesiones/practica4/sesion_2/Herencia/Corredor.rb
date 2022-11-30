require_relative "Deportista"
module Herencia
    class Corredor < Deportista

        def initialize(deportista)
            super(deportista.nombre, deportista.horas_entrenamiento)
        end

        def to_s
            result = "#{super}, es corredor.\n\n"
            return result
        end

        def competicion_deportiva
            result = "#{super}, #{correr}"
            return result
        end

        def correr
            result = "Está corriendo"
            return result
        end
        

    end
end