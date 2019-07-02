package co.com.ceiba.parqueadero.paola.dominio.constantes;

public final class Constantes {
	
	private Constantes() {}
	
	public static final String TIPO_VEHICULO_CARRO  = "CARRO";
	public static final String TIPO_VEHICULO_MOTO  = "MOTO";
	public static final String VACIO  = "";
	
	public static final int CANTIDAD_MAXIMA_MOTOS = 10;
	public static final int CANTIDAD_MAXIMA_CARROS = 20;
	
	public static final String LETRA_INICIO_PLACA = "A";
	
	public static final double VALOR_HORA_CARRO = 1000;
	public static final double VALOR_HORA_MOTO = 500;
	public static final double VALOR_DIA_CARRO = 8000;
	public static final double VALOR_DIA_MOTO = 4000;
	public static final double VALOR_ADICIONAL_TOPE_CILINDRAJE_MOTO = 2000;
	
	public static final int  TOPE_CILINDRAJE_MOTO = 500;
	
	public static final int TOPE_MIN_HORAS_COBRO_POR_DIA = 9;
	public static final int TOPE_MAX_HORAS_COBRO_POR_DIA = 24;
	public static final int MINUTOS_POR_HORA = 60;
	public static final int CERO = 0;	
	
	public static final String MENSAJE_TIPO_VEHICULO_VALIDO = "El tipo de vehículo a ingresar es válido para este estacionamiento";
	public static final String MENSAJE_TIPO_VEHICULO_NULO ="Debe ingresar un tipo de vehículo";
	public static final String MENSAJE_TIPO_VEHICULO_INCORRECTO ="Formato incorrecto del tipo de vehiculo";
	public static final String MENSAJE_CILINDRAJE_NO_NULO = "Debe ingresar el cilindraje de la moto";
	public static final String MENSAJE_PLACA_NULA = "Debe ingresar una placa";
	public static final String MENSAJE_NO_SE_PUEDE_ACTUALIZAR = "No se puede actualizar el registro no existe";
	public static final String MENSAJE_SOBRECUPO = "Actualmente no se cuenta con cupos disponibles para este vehículo";
	public static final String MENSAJE_ACCESO_NO_AUTORIZADO_PLACA = "La placa tiene restriccion para el día de hoy. No es posible ingresar";
	public static final String VEHICULO_YA_EXISTE_EN_PARQUEADERO = "Este vehículo ya se encuentra dentro del parqueadero. Por favor revisar";
	public static final String VEHICULO_NO_EXISTE_EN_PARQUEADERO = "Este vehículo no se encuentra dentro del parqueadero";

	public static final int  MILISEGUNDOS_A_MINUTOS = 60000;

	
}
