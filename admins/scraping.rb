require 'open-uri'
require 'cgi'

submitter = "2324"

Answer = Struct.new(:submission, :problem, :language)
answers = []

catch :unmatched do
  (1..Float::INFINITY).each do |page|
    url = "https://yukicoder.me/users/#{submitter}/submissions?page=#{page}&status=AC&date_asc=enabled"

    open(url) do |file|
      content = CGI.unescapeHTML(file.read.gsub("\n", ""))
      trs = content.scan(/<tr class="">.*?<\/tr>/) 
      throw :unmatched if trs.empty?
      
      trs.each do |tr|
        submission = tr[/\/submissions\/\d*/]
        problem = tr[/\/problems\/no\/\d*/]
        language = tr[/(?<=<td>)\w.*?(?=<\/td>)/]
        answers << Answer.new(submission, problem, language)
      end
    end

    sleep 1
  end
end

exts = {
  'Bash'       => 'sh',
  'C#'         => 'cs',
  'C++17(1z）' => 'cpp',
  'Java8'      => 'java',
  'Perl6'      => 'pl',
  'PyPy3'      => 'py',
  'Python3'    => 'py',
  'Ruby'       => 'rb',
  'Scheme'     => 'scm'
}

answers.each do |answer|
  ext = exts[answer.language]
  submission_id = answer.problem[/\d+/]
  filename = "#{submission_id}.#{ext}"
  
  source_url = "https://yukicoder.me#{answer.submission}/source"
  open(source_url) do |source|
    source = CGI.unescapeHTML(source.read)
    File.open(filename, 'w'){|file| file.puts(source)}
  end

  sleep 1
end
