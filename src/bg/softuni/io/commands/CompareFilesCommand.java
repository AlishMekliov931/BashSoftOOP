package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.annotations.Inject;
import bg.softuni.judge.Tester;
import bg.softuni.annotations.Alias;

@Alias("cmp")
public class CompareFilesCommand extends Command {
    @Inject
    private Tester tester;

    public CompareFilesCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 3) {
            throw new InvalidInputException(this.getInput());
        }

        String firstPath = data[1];
        String secondPath = data[2];
        this.tester.compareContent(firstPath, secondPath);
    }
}
