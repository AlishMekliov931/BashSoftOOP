package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.annotations.Inject;
import bg.softuni.network.DownloadManager;
import bg.softuni.annotations.Alias;

@Alias("download")
public class DownloadFileCommand extends Command {
    @Inject
    private DownloadManager downloadManager;

    public DownloadFileCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String fileUrl = data[1];
        this.downloadManager.download(fileUrl);
    }
}
