require_relative "Deportista"
module Herencia
    class Nadador < Deportista

        def initialize(deportista)
            super(deportista.nombre, deportista.horas_entrenamiento)
        end

        def to_s
            result = "#{super}, es nadador.\n\n"
            return result
        end

        def competicion_deportiva
            result = puts "#{super}, #{nadar}"
            return result
        end

        def nadar 
            result = "Está nadando"
            return result
        end

    end
end