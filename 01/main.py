from my_parser import Parser


def fuel_process(fuel):
    tmp_fuel = 0
    # Divide by 3
    tmp_fuel = fuel / 3
    # Round down
    tmp_fuel = int(tmp_fuel)
    # Substract 2
    tmp_fuel = tmp_fuel - 2
    return tmp_fuel


# Read file
my_parser = Parser("./input.txt")

fuel_sum = 0
fuel_down = 0
fuel_calc = 0

# Process each module mass to find the fuel required
for x in my_parser.sequence:
    # Calculate the fuel needed for the module
    fuel_calc = fuel_process(x)
    fuel_sum += fuel_calc
    fuel_down = fuel_calc
    # Calculate the fuel needed by the fuel itself
    while fuel_down > 0:
        fuel_calc = fuel_process(fuel_calc)
        if fuel_calc > 0:
            fuel_sum += fuel_calc
            fuel_down = fuel_calc
        else:
            fuel_down = 0
print("Total fuel requirements: {}".format(fuel_sum))
