package interview.dwolla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {
	class Command {
		public Command() {
		}

		public Command(String type, String name, boolean active) {
			this.type = type;
			this.name = name;
			this.active = active;
		}

		public String type;
		public String name;
		public boolean active;
	}

	class Device {
		public Device() {
		}

		public Device(String id, String[] capabilities) {
			this.id = id;
			this.capabilities = capabilities;
		}

		public String id;
		public String[] capabilities;
	}

	class Challenge {
		private Command[] commands() {
			Command[] array = new Command[9];
			array[0] = new Command("audio", "turn down volume", true);
			array[1] = new Command("audio", "turn up volume", true);
			array[2] = new Command("music", "next song", true);
			array[3] = new Command("music", "previous song", true);
			array[4] = new Command("music", "purchase song", false); // payment integration still in beta
			array[5] = new Command("channel", "channel up", true);
			array[6] = new Command("channel", "channel down", true);
			array[7] = new Command("temperature", "raise temperature", true);
			array[8] = new Command("temperature", "lower temperature", true);

			return array;
		}

		private Device[] devices() {
			Device[] array = new Device[5];
			array[0] = new Device("Television", new String[] { "audio", "channel" });
			array[1] = new Device("Stereo system", new String[] { "audio", "music" });
			array[2] = new Device("Kitchen sink", new String[0]);
			array[3] = new Device("Paper shredder", new String[] { "shredding" });
			array[4] = new Device("Smart thermostat", new String[] { "temperature" });
			return array;
		}
		
		public Device getDeviceById(String deviceId) throws IllegalArgumentException {
			Device[] allDevices = devices();
			for (Device device : allDevices) {
				if (device.id.equals(deviceId)) {
					return device;
				}
			}
			
			throw new IllegalArgumentException("Device not found");
		}
		
		public Command getCommandByCap(String cap) throws IllegalArgumentException {
			Command[] allCommands = commands();
			for (Command cmd : allCommands) {
				if (cmd.type.equals(cap))
					return cmd;
			}
			throw new IllegalArgumentException("Command per capability not found");
		}
		
		public ArrayList<Command> getCommandsByCap(String cap) {
			Command[] allCommands = commands();
//			ArrayList<Command> commands = new ArrayList<>();
//			for (Command cmd : allCommands) {
//				if (cmd.type.equals(cap))
//					commands.add(cmd);
//			}			
			ArrayList<Command> commands = (ArrayList<Command>) Stream.of(allCommands).filter(cmd -> cmd.type.equals(cap)).collect(Collectors.toList());
			return commands;
		}

		public ArrayList<String> listCommands(String deviceId) {
			try {
				Device device = getDeviceById(deviceId);
				ArrayList<String> outCommands = new ArrayList<>();
				for (String cap : device.capabilities) {
					ArrayList<Command> commands = getCommandsByCap(cap);
					for (Command cmd  : commands) {
						outCommands.add(cmd.name);
					}
				}
				return outCommands;
			} catch (IllegalArgumentException ex) {
				ex.printStackTrace();
				System.out.println(ex.getMessage());
				return null;
			}
		}

		public boolean checkValid(String commandName, String deviceId) {
			ArrayList<String> commandsByDevice = listCommands(deviceId);
			if (commandsByDevice.contains(commandName)) {
				return true;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
