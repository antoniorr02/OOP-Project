require_relative 'Vista_laberinto'
require_relative 'controlador_laberinto/Controlador'
require_relative 'modelo_laberinto/laberinto'

modelo = Modelo_laberinto::Laberinto.new
controlador = Controlador_laberinto::Controlador.new(modelo)
vista = Vista_laberinto.new(controlador)

vista.menu_usuario