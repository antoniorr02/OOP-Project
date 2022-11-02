require_relative 'vista2_laberinto.rb'
require_relative 'controlador_laberinto/Controlador.rb'
require_relative 'modelo_laberinto/laberinto.rb'

modelo = Modelo_laberinto::Laberinto.new
controlador = Controlador_laberinto::Controlador.new(modelo)
vista = Vista2_laberinto.new(controlador, modelo)

vista.menu_usuario